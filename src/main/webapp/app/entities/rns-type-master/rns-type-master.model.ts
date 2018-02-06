import { BaseEntity } from './../../shared';

export class RNS_TYPE_MASTER implements BaseEntity {
    constructor(
        public id?: number,
        public rNSCATGCODE?: string,
        public tYPECODE?: string,
        public tYPECODEDESC?: string,
        public rNSCATGMASTER?: BaseEntity,
    ) {
    }
}
